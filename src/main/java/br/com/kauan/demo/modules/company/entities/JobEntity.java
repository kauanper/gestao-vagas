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
    */
    @ManyToOne
    @JoinColumn(name = "company_id") //ao inserir um job, faz com que se verfique a existencia do id da compania
    private CompanyEntity company;

    @Column(name = "company_id") //faz dessa variavel representar a coluna respectiva
    private UUID companyId;      //não colocar resulta em variavel e coluna terem o mesmo nome

    @CreationTimestamp
    private LocalDateTime createdAt;
}
