# HM Validation

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
    @Repeatable(BaseRuleAnnotations.class)
    public @interface BaseRuleAnnotation {
        Class type();
    }
  ```
  - **BaseRuleAnnotation**: mỗi một rule annotation phải tạo thêm một class **BaseRuleAnnotations**(Annotation Repeatable) dùng để sử dụng nhìu **BaseRuleAnnotation** cho một field
  - Các annotation khác nếu có thêm các thuộc tính thì phải tạo **process** và ovverride lại **initValidation** và thêm process đó vô **FactoryProcess**
```
    @Override
    protected AbstractValidation initValidation(RegexRuleAnnotation annotation, AbstractValidation abstractValidation) {
        RegexValidation regexValidation = (RegexValidation) abstractValidation;
        regexValidation.setRegex( annotation.regex());
        return regexValidation;
    }
```
  - Mỗi một Custom Annotation thêm vô, khi tạo Annotation Repeatable vui lòng sử dụng **ProcessAnnotation.register(Class cl, BuilderAnnotations builderAnnotations)** để đăng kí sử lí, hoặc add trực tiếp vô **register** nếu là base.
# AbstractValidation
 - Kế thừa **AbstractValidation** để tạo ra một custom validation
 - Các hàm xử lí thêm vô có thể sử dụng trong **Process** của validation đó(ví dụ setRegex phía trên của RegexValidation)   