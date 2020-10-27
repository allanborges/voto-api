package com.voto.api.votoapi;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.statements.SpringRepeat;

import com.api.voto.controllers.VotoController;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = VotoController.class)
public class VotoControllerTest {

}
