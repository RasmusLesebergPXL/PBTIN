class VagrantHosts::Command::Puppetize < Vagrant.plugin('2', :command)

  include VagrantHosts::Command::Helpers
  include VagrantHosts::Addresses

  def self.synopsis
    'List private_network host info as Puppet Host resources'
  end

  def initialize(argv, env)
    @argv     = argv
    @env      = env
    @cmd_name = 'hosts puppetize'

    split_argv
  end

  def execute
    argv = parse_options(parser)

    @env.ui.info format_hosts
    0
  end

  private

  def format_hosts
    vagrant_hosts(@env).inject('') do |str, (address, aliases)|
      str << "host { '#{aliases.shift}':\n  ip => '#{address}',\n"
      str << "host_aliases => ['#{aliases.join('\', \' ')}'],\n" if (!aliases.empty?)
      str << "}\n"
    end
  end

  def parser
    OptionParser.new do |o|
      o.banner = "Usage: vagrant #{@cmd_name} [<args>]"
      o.separator ''

      o.on('-h', '--help', 'Display this help message') do
        puts o
        exit 0
      end
    end
  end
end
