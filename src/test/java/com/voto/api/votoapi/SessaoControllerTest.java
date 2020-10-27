package com.voto.api.votoapi;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.voto.controllers.SessaoController;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = SessaoController.class)
public class SessaoControllerTest {

}
