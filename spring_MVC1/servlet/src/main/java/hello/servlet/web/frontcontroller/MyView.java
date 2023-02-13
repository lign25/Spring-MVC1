package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//MyView를 만들어서 넘기는 로직 제작
public class MyView {
    private String viewPath; // FrontControllerServletV2으로부터 "/WEB-INF/views/new-form.jsp"를 전달받음

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //view를 만드는 행위 자체를 렌더링
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

    //render가 오면 model에 있는 값을 전부 꺼내서 HttpServlet request에 setAttribute로 전부 저장
    //*** jsp는 request.getAttribute()로 데이터를 조회하기 때문에 request.setAttribute()로 담는다. ***
    //이후 foward 로직을 수행
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
