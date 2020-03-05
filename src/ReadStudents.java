import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ReadStudents {
    public static void main(String[] args) throws IOException

    {
            String path=".\\studenti.txt";
         //   Scanner scanner=new Scanner(System.in);
            List<Student> studentList=new ArrayList<>();
            try{
                studentList=readStudents(new FileInputStream(path));
                //BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            Collections.sort(studentList);
            studentList.stream().forEach(each->System.out.println(each.getName()+" "+each.getSurname()+" "+each.getGrade()));
            HashMap<Character,Long> pojavuvanja=
                    studentList.stream().collect(Collectors.groupingBy(Student::getGrade,
                            LinkedHashMap::new,Collectors.counting()));
            pojavuvanja.entrySet().stream().forEach(each->System.out.println(each.getKey()+" : "+each.getValue()));
            PrintWriter printWriter=new PrintWriter(new FileWriter(".\\outputStudents.txt"));
            studentList.stream().forEach(each->printWriter.println(each));
            pojavuvanja.entrySet().stream().forEach(each->printWriter.println(each.getKey()+" "+each.getValue()));

    }
    static List<Student> readStudents(InputStream inputStream) throws IOException
    {
        ArrayList<Student> students=new ArrayList<>();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                String [] parts=line.split(":");
                String name=parts[0];
                String surname=parts[1];
                int exam1=Integer.parseInt(parts[2]);
                int exam2=Integer.parseInt(parts[3]);
                int exam3=Integer.parseInt(parts[4]);
                Student student=new Student(name,surname,exam1,exam2,exam3);
                students.add(student);
            }
        return students;
    }

}
