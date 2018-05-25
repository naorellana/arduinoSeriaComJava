
package com.norellanac.arduinoSerialCom.Controller;



import com.norellanac.arduinoSerialCom.model.serialComArduino;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    //@Autowired	

    @GetMapping("/inicio")
	public String init(HttpServletRequest req) {
                return "index";
	}
    @GetMapping("/control")
	public void delete(@RequestParam String motor, HttpServletRequest req, HttpServletResponse resp) throws IOException {
                //String sql="select * from usuarios order by id desc";
                //List usuarios=this.jdbcTemplate.queryForList(sql);
		//req.setAttribute("usuarios",usuarios);
                System.err.println("Comando: "+ motor);
                serialComArduino comArduino= new serialComArduino();
        comArduino.enviaDatoArduino(motor);
                resp.sendRedirect("/inicio");
                
        }

    
}
