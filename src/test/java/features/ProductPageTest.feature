Feature: Efetua testes na pagina Demoblaze

  Scenario: Faz a compra de um munitor
    Given acessar o site e loga no mesmo
    When escolher o produto correspondente a um munitor
    Then valida de o munitor foi comprado corretamente