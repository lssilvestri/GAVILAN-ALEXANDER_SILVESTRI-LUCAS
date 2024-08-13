package test;

import dao.impl.OdontologoDaoMemoria;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OdontologoServiceMemoriaTest {
    static Logger logger = Logger.getLogger(OdontologoServiceMemoriaTest.class);
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoMemoria());

    @Test
    @DisplayName("Testear que un odontologo se guarde en la base de datos")
    void caso1() {
        Odontologo odontologo = new Odontologo("ashdhas", "carlos", "perez");
        Odontologo odontologo1 = odontologoService.guardarOdontologo(odontologo);
        assertNotNull(odontologo1.getId());
    }

    @Test
    @DisplayName("Testear que se buscan todos los odontologos")
    void caso2() {
        odontologoService.guardarOdontologo(new Odontologo("ae123", "Juan", "Gomez"));
        odontologoService.guardarOdontologo(new Odontologo("rt456", "Ana", "Lopez"));

        List<Odontologo> odontologos = odontologoService.buscarTodos();

        assertTrue(odontologos.size() != 0);
    }
}