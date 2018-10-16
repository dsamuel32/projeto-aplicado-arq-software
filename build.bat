cd agendamento-service
call mvn dockerfile:build
cd ..
cd api-gateway
call mvn dockerfile:build
cd ..
cd cadastro-service
call mvn dockerfile:build
cd ..
cd discovery-server
call mvn dockerfile:build
cd ..
cd notificacao-service
call mvn dockerfile:build
cd ..
cd pagamento-service
call mvn dockerfile:build
cd ..
cd relatorio-service
call mvn dockerfile:build