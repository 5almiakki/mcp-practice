package kwc.mcppractice;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "kwc_get_courses", description = "Get a list of courses from KWC")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "kwc_get_course", description = "Get a single course from KWC by title")
    public Course getCourse(String title) {
        return courses.stream().filter(course -> course.title().equals(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing courses...");
        courses.add(new Course("Java", "http://www.example.com/Java"));
        courses.add(new Course("Spring", "http://www.example.com/Spring"));
    }

}
