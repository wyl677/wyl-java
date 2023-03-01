import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * @auther yanl.wang
 * @date 2023/3/1
 **/
public class MyTest {

    @Test
    public void test1(){
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String s = desktopDir.getAbsolutePath();
        System.out.println(s);
    }
}
