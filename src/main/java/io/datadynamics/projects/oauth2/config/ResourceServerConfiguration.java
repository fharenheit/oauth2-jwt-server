@Congiruation
@EnableREsourceSErver
ResourceServerConfiguration extens ResourceServerConfigurerAdapter {

@Override
configure(HttpSeurity http) {
http.csrf().disable()
.sessionManagement().sessionCreationPolicy(SessionCrationPolicy.NEVER)
.and()
.authroizedRequestS()
.antMatchers(/sercice/**)
.anyRequest().authenticatd()
.and().logout()

@Override
configure(ResoruceServerSecurityConfigurere resources) {
super.configure(resorues);
}
