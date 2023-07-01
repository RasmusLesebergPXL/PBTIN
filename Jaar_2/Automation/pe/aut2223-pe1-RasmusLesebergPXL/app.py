import psutil
import platform
import distro
import socket
from pyramid.config import Configurator
from pyramid.response import Response
from waitress import serve

def get_aws_id(request):
    hostname = socket.gethostname()
    architecture = platform.machine()
    ram = psutil.virtual_memory().total / (1024 ** 3) # Convert to GB
    distro_info = distro.linux_distribution(full_distribution_name=False)
    distro_name = distro_info[0] if distro_info else 'Unknown'
    distro_version = distro_info[1] if distro_info else 'Unknown'
    return Response(f"Hostname: {hostname}\nArchitecture: {architecture}\nRAM: {ram:.2f} GB\nDistribution: {distro_name} {distro_version}")
config = Configurator()
config.add_route('hostname', '/hostname')
config.add_view(get_aws_id, route_name='hostname')

app = config.make_wsgi_app()
serve(app, host='0.0.0.0', port=5000)
