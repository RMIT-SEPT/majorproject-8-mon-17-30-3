import React from "react";
import {shallow, mount} from "enzyme";
import Enzyme from "enzyme";
import Adapter from "enzyme-adapter-react-16";
import App from "./App";

Enzyme.configure({ adapter: new Adapter()});

describe(" Make Booking tests", ()=>{
    const mockFn = jest.fn();
})
it("should render app", ()=> {
    const component = shallow(<App />);
    expect(component).toHaveLength(1);
})
