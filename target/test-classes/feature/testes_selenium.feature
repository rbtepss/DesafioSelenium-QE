# language: pt
#encoding: utf-8

Funcionalidade: Preencher formularios para enviar email no site sampleapp

    Cenario: Preenchimento de formularios e submissao de email
        Dado que entrei no site
        E selecione a aba Vehicle Data
        E preencha o formulario Vehicle Data e pressiona next
        E preencha o formulario Insurant Data e presiona next
        E preencha o formulario Product Data e presiona next
        E preencha o formulario Price Option e presiona next
        E preencha o formulario Send Quote e pressione send
        Entao verifique na tela a mensagem "Sending e-mail success!"
