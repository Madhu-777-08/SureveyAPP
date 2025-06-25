package test.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class SurveyContollerServlet
 */
@WebServlet("/api/surveys")
public class SurveyContollerServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private static final String FILE_PATH = "D:\\SAVEAIDATAAPP\\LOGINDETAILS\\surveys.jsonl";
   
    	    @Override
    	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	        StringBuilder jsonBuilder = new StringBuilder();
    	        try (BufferedReader reader = request.getReader()) {
    	            String line;
    	            while ((line = reader.readLine()) != null) {
    	                jsonBuilder.append(line);
    	            }
    	        }

    	        String surveyJson = jsonBuilder.toString();

    	        // Save survey as a line
    	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
    	            writer.write(surveyJson);
    	            writer.newLine();
    	        }

    	        response.setStatus(HttpServletResponse.SC_OK);
    	    }
    	
    }
