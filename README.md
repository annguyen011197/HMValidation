# HM Validation

# Annotation Support
   * Size: size of String, Collection, Map
   * Regex: regex of String
   * NotNull: not null
   * NotEmpty: not null or empty (String, Collection, Map)
   * ContainArrayString: String contain in array string
# Features
   * Support path "$.var1.var2" (Size(target="$.var1"))
   * Support path with array "$.list[0].name"
   * Support validation in element of list
   * Support Size, Regex, NotNull, NotEmpty, ContainArrayString
   * Support custom validation
# Changelog
   * 17/12/2018
        + @Deprecated: ProcessAnnotation
        + Đổi cấu trúc Annotation
        + Validation -> FactoryProcess -> IProcess -> AbstractValidation -> Result
        + [Định hướng] Lấy target từ path "$.var1.var2" (Size(target="$.var1"))
        + 
# Workflow

  - Chạy **Validation.runObserver(Object object,ResultObserver observer)**;
  - **runObserver**: Chạy duyệt tất cả fields -> Mỗi field duyệt tất cả Annotation lấy danh sách này xử lý thông qua **ProcessAnnotation.process(Annotation[] array)** [Sẽ chuyển từ annotation Repeatable sang đơn]
  - Từ mỗi Annotation lấy ra một **IProcess** từ **FactoryProcess** và chạy **iProcess.process(T annotation, Object object, Field field)**
  - **process**: Lấy class **AbstractValidation** từ annotation ra, tạo instance và chạy **validation**
  - Lấy kết quả từ **process** tạo **Result** và gửi trờ về thông qua **ResultObserver.update**

# Annotation
  ```
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface NotNull {
        Class type = NullValidation.class;
        String message() default "";
    }
  ```
  - **BaseRuleAnnotation**: mỗi một rule annotation phải tạo thêm một class **BaseRuleAnnotations**(Annotation Repeatable) dùng để sử dụng nhìu **BaseRuleAnnotation** cho một field
  - Các annotation khác nếu có thêm các thuộc tính thì phải tạo **process** và override lại **initValidation** và thêm process đó vô **FactoryProcess**
```
    @Override
    protected AbstractValidation initValidation(RegexRuleAnnotation annotation, AbstractValidation abstractValidation) {
        RegexValidation regexValidation = (RegexValidation) abstractValidation;
        regexValidation.setRegex( annotation.regex());
        return regexValidation;
    }
```
  - Mỗi một Custom Annotation thêm vô, khi tạo Annotation Repeatable vui lòng sử dụng **ProcessAnnotation.register(Class cl, BuilderAnnotations builderAnnotations)** để đăng kí sử lí, hoặc add trực tiếp vô **register** nếu là base.
  - FactoryProcess tương tự trên.
# AbstractValidation
 - Kế thừa **AbstractValidation** để tạo ra một custom validation
 - Các hàm xử lí thêm vô có thể sử dụng trong **Process** của validation đó(ví dụ setRegex phía trên của RegexValidation)   
