cd agendamento
call docker build -t projeto-aplicado-agendamentodb .
cd ..
cd cadastro
call docker build -t projeto-aplicado-cadastrodb .
cd ..
cd notificacao
call docker build -t projeto-aplicado-notificacaodb .