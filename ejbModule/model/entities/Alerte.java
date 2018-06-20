package model.entities;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.refs.Messages;
import model.refs.entities.AbstractEntity;


@SuppressWarnings("serial")


//CDI
@Dependent

//JPA
@Entity
@Table(name="ALERTE")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Alerte extends AbstractEntity{
	
	@Pattern(regexp = "[A-Za-z]*")
	@NotNull(message= Messages.ERREUR_LIBELLE_ALERTE)
	@Column(name="LIBELLE")
	String libelle;
	
	
}