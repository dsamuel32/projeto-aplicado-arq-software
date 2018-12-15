{
  "swagger": "2.0",
  "info": {
    "description": "Endpoints do projeto API Template",
    "version": "0.0.1",
    "title": "API Template",
    "license": {
      "name": "Sem Licença",
      "url": "http://www.google.com"
    }
  },
  "host": "localhost:8080",
  "basePath": "/",
  "tags": [
    {
      "name": "informacoes"
    }
  ],
  "schemes": [
    "http"
  ],
  "paths": {
    "/informacoes": {
      "get": {
        "tags": [
          "informacoes"
        ],
        "summary": "Recupear as informações do sistema",
        "description": "",
        "operationId": "informacoes",
        "produces": [
          "application/json"
        ],
        "responses": {
          "200": {
            "description": "Informaçãoes do sistema recuperadas.",
            "schema": {
              "$ref": "#/definitions/informacoes"
            }
          }
        }
      }
    }
  },
  "definitions": {
    "informacoes": {
      "type": "object",
      "properties": {
        "_id": {
          "type": "string",
          "example": "5bc75c8df70abf1b209aee76"
        },
        "nome": {
          "type": "string",
          "example": "api-template"
        },
        "versao": {
          "type": "string",
          "example": "0.0.1"
        }
      }
    }
  }
}