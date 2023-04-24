# Springboot_part-1_Implementing_conceitual_model
First part of a spring project- Implementing Conceitual Model based on the class and object diagrams

@Autowired Essa anotação é usada para injetar automaticamente um objeto em um componente da aplicação, sem a necessidade de criar e configurar manualmente esse objeto. ex:

        @Service
        public class UserService {

            private UserRepository userRepository;

            @Autowired
            public UserService(UserRepository userRepository) {
                this.userRepository = userRepository;
            }

            // ...
        }


@JsonManagedReference é usado para resolver o problema de referências circulares em objetos Java que precisam ser convertidos em JSON. Isso ocorre quando há uma relação bidirecional entre duas entidades e, ao converter uma dessas entidades em JSON, a biblioteca Jackson entra em um loop infinito porque não sabe quando parar.

@JsonBackReference é a contrapartida de @JsonManagedReference. Ele é usado para lidar com o lado "ignorado" da relação, que é a entidade que não é serializada.