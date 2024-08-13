package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(OdontologoDaoMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologos.size() + 1);
        odontologos.add(odontologo);
        logger.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        for (Odontologo odontologo : odontologos) {
            logger.info("Odontologo encontrado: " + odontologo);
        }
        return odontologos;
    }
}
