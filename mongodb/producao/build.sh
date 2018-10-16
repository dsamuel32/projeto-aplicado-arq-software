#!/bin/bash
cd agendamento
docker build -t projeto-aplicado-agendamentodb .
cd ..
cd cadastro
docker build -t projeto-aplicado-cadastrodb .
cd ..
cd notificacao
docker build -t projeto-aplicado-notificacaodb .