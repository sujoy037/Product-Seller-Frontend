import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomePage from './pages/home/HomePage'
import LoginPage from './pages/login/LoginPage'
import RegistrationPage from './pages/register/RegistrationPage'
import ProfilePage from './pages/profile/ProfilePage'
import NotFoundPage from './pages/not-found/NotFoundPage'
import UnauthorizePage from './pages/unauthorize/UnauthorizePage'
import AdminPage from './pages/admin/AdminPage'
import { AuthGurd } from './guard/auth.guard';
import { Role } from './model/Role';

function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <div className='container'>
        <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/home' element={<HomePage />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/register' element={<RegistrationPage />} />

        <Route path='/profile' element={
            <AuthGurd roles={[Role.ADMIN,Role.USER]}>
            <ProfilePage />
            </AuthGurd>
          }
         />

        <Route path='/admin' element={
          <AuthGurd roles={[Role.ADMIN]}>
          <AdminPage />
          </AuthGurd>
         }/>
         
        <Route path='/404' element={<NotFoundPage />} />
        <Route path='/401' element={<UnauthorizePage />} />
        <Route path='*' element={<NotFoundPage />} />
        </Routes>
       
      </div>
    </BrowserRouter>

  );
}

export default App;
