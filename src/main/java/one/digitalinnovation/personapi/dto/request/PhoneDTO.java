package one.digitalinnovation.personapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PhoneDTO {
	

	private Long id;
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private PhoneType type;
	@NotEmpty
	@Size(min = 9, max = 15, message = "O campo número precisa ser preenchido e tem que ter no mínimo 9 e no máximo 15 caracteres")
	private String numero;

}
