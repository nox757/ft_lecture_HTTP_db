package fintechQA.gen.sources;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoaderFileResource {

    public static List<String> loadResource(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            list = stream
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }


}