package one.digitalinnovation.personapi.model;

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
@Entity
@Table(name = "PESSOAS")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( nullable = false, length = 25)
	private String firstName;
	@Column( nullable = false, length = 25)
	private String lastName;
	@Column( nullable = false, length = 15, unique = true)
	private String cpf;
	@Column( nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Phone> phones;
	
	
	@Override
	public String toString() {
		String person = String.format("Nome = %s, sobreNome = %s, cpf = %s e dataNascimento = %s", this.firstName, this.lastName, this.cpf, this.dataNascimento);
		return person;
	}
}
