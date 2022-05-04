{application, 'rabbitmq_random_exchange', [
	{description, "RabbitMQ Random Exchange"},
	{vsn, "3.9.15"},
	{id, "v3.9.14-50-ga0adda2"},
	{modules, ['rabbit_exchange_type_random']},
	{registered, []},
	{applications, [kernel,stdlib,rabbit_common,rabbit]},
	{env, []}
]}.