package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import model.refs.entities.AssociationEntityUUID;


@SuppressWarnings("serial")


//CDI
@Dependent

//JPA
@Entity
@Table(name="SE_SITUER")
@Getter
@Setter
@IdClass( AssociationEntityUUID.class )
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class SeSituer  implements Serializable{
	
	
	@Id
	@NotNull
	UUID idTable1;
	
	@Id 
	@NotNull
	UUID idTable2;
	
	@Id 
	@NotNull
	@Column(name="DATE_DEBUT")
	LocalDate dateDebut;
	
	@Column(name="DATE_FIN")
	LocalDate dateFin;
	
	@ManyToOne( cascade = CascadeType.PERSIST )
	@JoinColumn( name = "POSITION_ID", insertable = false, updatable = false )
	Position position;
	
	
	@ManyToOne( cascade = CascadeType.PERSIST )
	@JoinColumn( name = "ACTIVITE_ID", insertable = false, updatable = false )
	Activite activite;
	

}
