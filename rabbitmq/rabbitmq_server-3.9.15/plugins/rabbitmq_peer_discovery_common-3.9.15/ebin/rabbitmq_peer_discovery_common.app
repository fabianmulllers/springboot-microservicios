{application, 'rabbitmq_peer_discovery_common', [
	{description, "Modules shared by various peer discovery backends"},
	{vsn, "3.9.15"},
	{id, "v3.9.14-50-ga0adda2"},
	{modules, ['rabbit_peer_discovery_cleanup','rabbit_peer_discovery_common_app','rabbit_peer_discovery_common_sup','rabbit_peer_discovery_config','rabbit_peer_discovery_httpc','rabbit_peer_discovery_util']},
	{registered, [rabbitmq_peer_discovery_common_sup]},
	{applications, [kernel,stdlib,inets,rabbit_common,rabbit]},
	{mod, {rabbit_peer_discovery_common_app, []}},
	{env, []}
]}.