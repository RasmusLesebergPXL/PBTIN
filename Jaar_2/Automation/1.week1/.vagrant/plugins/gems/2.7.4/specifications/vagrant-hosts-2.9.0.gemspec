# -*- encoding: utf-8 -*-
# stub: vagrant-hosts 2.9.0 ruby lib

Gem::Specification.new do |s|
  s.name = "vagrant-hosts".freeze
  s.version = "2.9.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0".freeze) if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib".freeze]
  s.authors = ["Adrien Thebo".freeze, "Charlie Sharpsteen".freeze]
  s.date = "2019-01-03"
  s.description = "    Manage static DNS entries and configuration for Vagrant guests.\n".freeze
  s.email = ["adrien@somethingsinistral.net".freeze, "source@sharpsteen.net".freeze]
  s.homepage = "https://github.com/oscar-stack/vagrant-hosts".freeze
  s.licenses = ["Apache 2.0".freeze]
  s.rubygems_version = "3.1.6".freeze
  s.summary = "Manage static DNS on vagrant guests".freeze

  s.installed_by_version = "3.1.6" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4
  end

  if s.respond_to? :add_runtime_dependency then
    s.add_development_dependency(%q<rake>.freeze, ["~> 10.0"])
    s.add_development_dependency(%q<rspec>.freeze, ["~> 2.14.0"])
  else
    s.add_dependency(%q<rake>.freeze, ["~> 10.0"])
    s.add_dependency(%q<rspec>.freeze, ["~> 2.14.0"])
  end
end
