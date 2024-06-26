package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repositories.DisciplinaRepository;
import br.com.alunoonline.api.repositories.disciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina create(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(Long id) {
        return disciplinaRepository.findById(id);
    }

    public void update(Long id, Disciplina disciplina){
        Optional<Disciplina>disciplinaFromDb = findById(id);

        if (disciplinaFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrado no banco de dados");
        }
        Disciplina disciplinaUpdated = disciplinaFromDb.get();

        disciplinaUpdated.setName((disciplina.getName()));
        disciplinaUpdated.setProfessor(disciplina.getProfessor());
        disciplinaRepository.save(disciplinaUpdated);
    }


    public void delete(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
