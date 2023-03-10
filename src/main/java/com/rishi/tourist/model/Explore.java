package com.rishi.tourist.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.rishi.tourist.util.*;

import lombok.Data;

@Data
@Table(name = "tourist_explore")
@Entity
public class Explore {
	//
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "explore_id_seq")
	@SequenceGenerator(name = "explore_id_seq",sequenceName = "explore_id_seq")
	long id;
//	public static void main(String[] args)
//    {
//		ExploreUtil e = ExploreUtil.HOLIDAYS;
//      
//        switch (e) {
//      
//        case WINTER:
//            System.out.println("WINTER");
//            break;
//        case SUMMER:
//            System.out.println("SUMMER");
//            break;
//        case RAINY:
//            System.out.println("RAINY");
//            break;
//        case HOLIDAYS:
//            System.out.println("HOLIDAYS");
//            break;
//        default:
//            System.out.println("sorry we couldn't find");
//        }
//    }
}


