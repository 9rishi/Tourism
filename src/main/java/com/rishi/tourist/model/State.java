package com.rishi.tourist.model;
/*
 * package com.rishi.tourist.model;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.OneToOne; import javax.persistence.SequenceGenerator;
 * import javax.persistence.Table; import javax.validation.constraints.NotNull;
 * import javax.validation.constraints.Size;
 * 
 * import lombok.Data;
 * 
 * @Entity
 * 
 * @Table(name = "state-Name")
 * 
 * @Data public class State {
 * 
 * //
 * 
 * @Id
 * 
 * @GeneratedValue( strategy = GenerationType.SEQUENCE,generator =
 * "booking_id_seq")
 * 
 * @SequenceGenerator(name = "booking_id_seq",sequenceName = "booking_id_seq")
 * long id; //
 * 
 * @Column(length = 100)
 * 
 * @NotNull(message = "stateName shouldn't be empty")
 * 
 * @Size(min = 3) String stateName; //
 * 
 * @OneToOne
 * 
 * @JoinColumn(name = "fk_state") Country country;
 * 
 * }
 */