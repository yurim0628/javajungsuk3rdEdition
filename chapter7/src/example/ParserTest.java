package example;

// Parseable 인터페이스는 parse 메서드를 선언하는 인터페이스입니다.
interface Parseable {
    // 문자열 fileName을 파싱하는 추상 메서드를 정의합니다.
    public abstract void parse(String fileName);
}

// ParserManager 클래스는 Parseable 인터페이스를 반환하는 getParser 메서드를 가지고 있습니다.
class ParserManager {
    // 파서 타입(type)에 따라 적절한 Parseable 인터페이스를 반환합니다.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser(); // XMLParser 객체를 반환합니다.
        } else {
            Parseable p = new HTMLParser();
            return p;
            // return new HTMLParser(); // HTMLParser 객체를 반환합니다.
        }
    }
}

// XMLParser 클래스는 Parseable 인터페이스를 구현하여 parse 메서드를 오버라이딩합니다.
class XMLParser implements Parseable {
    public void parse(String fileName) {
        /* 주어진 파일명을 이용하여 XML 문서를 파싱하는 작업을 수행합니다. */
        System.out.println(fileName + "- XML parsing completed.");
    }
}

// HTMLParser 클래스는 Parseable 인터페이스를 구현하여 parse 메서드를 오버라이딩합니다.
class HTMLParser implements Parseable {
    public void parse(String fileName) {
        /* 주어진 파일명을 이용하여 HTML 문서를 파싱하는 작업을 수행합니다. */
        System.out.println(fileName + "- HTML parsing completed.");
    }
}

// ParserTest 클래스는 ParserManager 클래스를 이용하여 XMLParser와 HTMLParser를 사용하는 예제를 보여줍니다.
class ParserTest {
    public static void main(String args[]) {
        Parseable parser = ParserManager.getParser("XML"); // ParserManager를 통해 XMLParser 객체를 얻어옵니다.
        parser.parse("document.xml"); // XMLParser의 parse 메서드를 호출하여 "document.xml"을 파싱합니다.

        parser = ParserManager.getParser("HTML"); // ParserManager를 통해 HTMLParser 객체를 얻어옵니다.
        parser.parse("document2.html"); // HTMLParser의 parse 메서드를 호출하여 "document2.html"을 파싱합니다.
    }
}

