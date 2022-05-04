{application, 'rabbitmq_event_exchange', [
	{description, "Event Exchange Type"},
	{vsn, "3.9.15"},
	{id, "v3.9.14-50-ga0adda2"},
	{modules, ['rabbit_event_exchange_decorator','rabbit_exchange_type_event']},
	{registered, []},
	{applications, [kernel,stdlib,rabbit_common,rabbit]},
	{env, []},
		{broker_version_requirements, []}
]}.