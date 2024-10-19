package mx.unam.dgtic.participacion1.controller;

import mx.unam.dgtic.participacion1.model.Estudiante;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    HashMap<Integer, Estudiante> estudiantes;
    List<String> participantes;

    public EstudianteRestController() {

        participantes = new ArrayList<>();
        participantes.add("Carlos Andres Rodriguez");
        participantes.add("Francisco Miztli López Salinas");
        participantes.add("José Fernando Castañeda Estrada");
        participantes.add("Juan Fernando Gonzalez Castro");

        estudiantes = new HashMap<>();
        estudiantes.put(1, new Estudiante(1, "Ana", "Lopez", "ana.lopez@diplomado-java.unam.mx"));
        estudiantes.put(2, new Estudiante(2, "Jose", "Gonzalez", "jose.gonzalez@diplomado-java.unam.mx"));
        estudiantes.put(3, new Estudiante(3, "Marcos", "Ramirez", "marcos.ramirez@diplomado-java.unam.mx"));
        estudiantes.put(4, new Estudiante(4, "Diana", "Sanchez", "diana.sanchez@diplomado-java.unam.mx"));
        estudiantes.put(5, new Estudiante(5, "Pedro", "Pardo", "pedro.pardo@diplomado-java.unam.mx"));

    }

    @GetMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<Integer, Estudiante>> getEstudiantes() {
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable int id) {
        Estudiante estudiante = estudiantes.getOrDefault(id, null);

        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        int id = 1;
        while (estudiantes.containsKey(id)) {
            id++;
        }
        estudiante.setMatricula(id);
        estudiantes.put(id, estudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante) {
        if (estudiantes.containsKey(id)) {
            estudiante.setMatricula(id);
            estudiantes.replace(id, estudiante);
            return ResponseEntity.ok(estudiantes.get(id));
        } else {
            estudiantes.put(id, estudiante);
            return new ResponseEntity<>(estudiantes.get(id), HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateNotSupported() {
        return new ResponseEntity<>("'msg':'Acción no permitida'", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PatchMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> updatePartialEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteDB = estudiantes.get(id);
        if (estudiante == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        if (estudianteDB == null) {
            return ResponseEntity.notFound().build();
        }
        if (estudiante.getNombre() != null) {
            estudianteDB.setNombre(estudiante.getNombre());
        }
        if (estudiante.getApellido() != null) {
            estudianteDB.setApellido(estudiante.getApellido());
        }
        if (estudiante.getCorreo() != null) {
            estudianteDB.setCorreo(estudiante.getCorreo());
        }
        estudiantes.replace(id, estudianteDB);
        return ResponseEntity.ok(estudiantes.get(id));
    }

    @PatchMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePartialNotSupported() {
        return new ResponseEntity<>("'msg':'Acción no permitida'", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @DeleteMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> deleteEstudiante(@PathVariable int id) {
        if (estudiantes.containsKey(id)) {
            return ResponseEntity.ok(estudiantes.remove(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteNotSupported() {
        return new ResponseEntity<>("'msg':'Acción no permitida'", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping(path = "/creditos", produces = MediaType.TEXT_HTML_VALUE)
    public String creditos() {
        StringBuilder integrantes = new StringBuilder();
        for (String participante : participantes) {
            integrantes.append("        <li>" + participante + "</li>\n");
        }
        return "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Lista de Estudiantes</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            line-height: 1.6;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        ul {\n" +
                "            list-style-type: none;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        li {\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin-bottom: 10px;\n" +
                "            padding: 10px;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Lista de Estudiantes ejercicio 1</h1>\n" +
                "    <ul>\n" +
                integrantes.toString() +
                "    </ul>\n" +
                "</body>\n" +
                "</html>";
    }

}
