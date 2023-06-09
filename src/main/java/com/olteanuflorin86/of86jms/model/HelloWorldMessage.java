package com.olteanuflorin86.of86jms.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelloWorldMessage implements Serializable {

	private static final long serialVersionUID = 1196309541376123416L;
	
	private UUID id;
	private String message;
}
