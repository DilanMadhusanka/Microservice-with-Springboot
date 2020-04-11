package com.microservice.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.pathologyservice.models.Disease;

@RestController
public class PathologyResource {

	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Ashma", "Warm water bath"),
			new Disease("D2", "Thyphoid", "Ampicilin capsule!"));
}
