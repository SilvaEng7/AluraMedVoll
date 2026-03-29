/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package med.voll.api.dto;

import med.voll.api.entities.Medico;
import med.voll.api.enums.Especialidade;


public record DadosListagemMedicoDTO(
    Long id,
    String nome, 
    String crm, 
    Especialidade especialidade,
    String email
) {
    public DadosListagemMedicoDTO(Medico medico) {
        this(
            medico.getId(), 
            medico.getNome(), 
            medico.getCrm(), 
            medico.getEspecialidade(), 
            medico.getEmail()
        );

    }
}
