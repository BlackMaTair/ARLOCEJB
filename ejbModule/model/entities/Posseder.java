package model.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.refs.NiveauDanger;
import model.refs.entities.AssociationEntityEnum;


//CDI
@Dependent

//JPA
@Entity
@Table(name="POSSEDER")
@Getter
@Setter
@NoArgsConstructor
@IdClass( AssociationEntityEnum.class )
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Posseder{
	
	
	@Id
	@NotNull
	UUID idTable1;
	
	@Id 
	@NotNull
	NiveauDanger enumeration;
	
	@Id 
	@NotNull
	@Column(name="DATE_DEBUT")
	LocalDate dateDebut;
	

	@Column(name="DATE_FIN")
	LocalDate dateFin;
	
	@ManyToOne( cascade = CascadeType.PERSIST )
	@JoinColumn( name = "CIBLE_ID", insertable = false, updatable = false )
	Cible cible;
	
	
	
	@Enumerated(EnumType.STRING)
	NiveauDanger niveauDanger;
	

}