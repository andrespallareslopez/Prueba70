SELECT userid,
       username,
       state,
       aud_usu,
       aud_tim
FROM public.usuarios
LIMIT 1000;


delete from usuarios;