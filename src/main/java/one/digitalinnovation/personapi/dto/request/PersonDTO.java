package one.digitalinnovation.personapi.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PersonDTO {

    
	private Long id;
    @NotEmpty
    @Size(min = 5, max = 25, message = "O campo firstName precisa ter entre 5 e 25 caracteres")
	private String firstName;
    @NotEmpty
    @Size(min = 5, max = 25, message = "O campo lastName precisa ter entre 5 e 25 caracteres")
	private String lastName;
    @NotEmpty
    @Size(min = 5, max = 15, message = "O campo cpf precisa ser preenchido obrigatóriamente")
	private String cpf;
    @NotEmpty(message = "O campo data de nascimento precisa ser preenchido")
	private String dataNascimento;
     
	private List<PhoneDTO> phones;
	
	
	@Override
	public String toString() {
		String person = String.format("Nome = %s, sobreNome = %s, cpf = %s e dataNascimento = %s", this.firstName, this.lastName, this.cpf, this.dataNascimento);
		return person;
	}
}
