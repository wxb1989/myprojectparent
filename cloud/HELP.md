# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)

spring-boot简单的整合框架
https://springboot.plus/

vue父子组件双向通信子组件使用

    <template>
        <div class="modal" :value="value" v-show="visible">
            <div class="close" @click="cancel">X</div>
        </div>
    </template>
    
    <script>
        export default {
            props: {
                value: {
                    type: Boolean,
                    default: false
                }
            },
            data () {
                return {
                    visible: this.value
                }
            },
            watch: {
                value(val) {
                    console.log(val);
                    this.visible = val;
                }
            },
            methods: {
                cancel(){
                    this.visible = false;
                    console.log('$emit(input');
                    this.$emit('input', this.visible);
                }
            },
        }
    </script>

