{application, 'seshat', [
	{description, "Counters"},
	{vsn, "0.1.0"},
	{id, "v3.9.14-50-ga0adda2"},
	{modules, ['seshat_app','seshat_counters','seshat_counters_server','seshat_sup']},
	{registered, [seshat_sup]},
	{applications, [kernel,stdlib,sasl,crypto]},
	{mod, {seshat_app, []}},
	{env, [
]}
]}.