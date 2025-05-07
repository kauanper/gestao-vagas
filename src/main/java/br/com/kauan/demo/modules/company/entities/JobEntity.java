package br.com.kauan.demo.modules.company.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ValueGenerationType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String level;
    private String description;
    private String beneficiary;

    /*
    entender qual o nivel da relação entre as tabelas, no caso o relacionamento se dá, da tabela que está sendo criada
    para a tabela em q será associada
    nesse caso em questão: Muitos Jobs para uma Company
    Não é estritamente necessário ter a referência private CompanyEntity company. Ela é opcional, mas muito útil dependendo
    de como você quer trabalhar com os dados.
    Quando é necessário ter a referência (company):
    Quando você quer acessar diretamente os dados da empresa a partir do Job, sem precisar fazer outra consulta manual.
    */
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false) //ao inserir um job, faz com que se verfique a existencia do id da compania
    private CompanyEntity company;

    @Column(name = "company_id") //campo que realmente vai ser escrito.
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
