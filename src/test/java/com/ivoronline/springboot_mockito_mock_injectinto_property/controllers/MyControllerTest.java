package com.ivoronline.springboot_mockito_mock_injectinto_property.controllers;

import com.ivoronline.springboot_mockito_mock_injectinto_property.entities.Person;
import com.ivoronline.springboot_mockito_mock_injectinto_property.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @Mock PersonRepository personRepository;

  //INSTANTIATE CLASS BEING TESTED. INJECT MOCKS (WHERE @AUTOWIRED IS USED)
  @InjectMocks MyController myController;

  @Test
  void getPerson() {

    //MOCK REPOSITORY'S METHOD: getPersonById(1)
    when(personRepository.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));

    //TEST CONTROLLER'S ENDPOINT
    String result = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Hello Susan", result);

  }

}



