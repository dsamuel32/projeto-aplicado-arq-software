cd agendamento
call docker build -t agendamentodb .
cd ..
cd cadastro
call docker build -t cadastrodb .
cd ..
cd notificacao
cd ..
call docker build -t notificacaodb .
cd pagamento
call docker build -t pagamentodb .