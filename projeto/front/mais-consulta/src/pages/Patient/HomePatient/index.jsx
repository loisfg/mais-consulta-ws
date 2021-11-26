import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Schedule, WelcomeMessage } from "../../../components";
import { data as oldData} from './data'

export const HomePatient = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    async function getSchedule() {
      try {
        // const res = await api('maisconsulta').get('/paciente/agenda');
        // setData(res.data)
        setData(oldData)
      } catch (error) {
        console.log(error)
      }
    }
  })

  return (
    <Page>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic/>
        </DivUsuario>
        <Content>
          <WelcomeMessage />
          <Schedule data={data}/>
        </Content>
      </AuxDiv>
    </Page>
  );
};
