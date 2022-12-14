package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	@GetMapping("/listarCursos")
	public ModelAndView listaTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
		mv.addObject("cursos", cursoService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarCursos")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView ("curso/cadastrarCursos");
		mv.addObject("Curso",new Curso());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.insert(curso);
		return listaTodosCursos();
	}
	
	@PostMapping("/excluir/{idX}")
	public ModelAndView excluirCurso(@PathVariable("idX")Integer id) {
		cursoService.delete(id);
		return listaTodosCursos();
	}
	
	
}
