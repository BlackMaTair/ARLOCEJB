package model.entities;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
@Table(name="POSITION")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Position extends AbstractEntity{
	
	
	@NotNull
	@Min(value=-180,message=Messages.ERREUR_LONGITUDE_MIN)
	@Max(value=180,message=Messages.ERREUR_LONGITUDE_MAX)
	@Column(name="LONGITUDE")
	int longitude;
	
	
	@NotNull
	@Min(value=-90,message=Messages.ERREUR_LATITUDE_MIN)
	@Max(value=90,message=Messages.ERREUR_LATITUDE_MAX)
	@Column(name="LATITUDE")
	int latitude;
	
	

}
