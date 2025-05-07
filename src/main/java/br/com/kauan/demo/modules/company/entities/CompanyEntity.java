package br.com.kauan.demo.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @Email(message = "O campo email deve conter um e-mail válido")
    private String email;

    @NotBlank(message = "Defina uma senha")
    @Length(min = 6, max = 6)
    private String password;

    private String websiteUrl;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
