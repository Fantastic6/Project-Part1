package sample;/*
 *
 * Name: CPU.java
 * Author: Richard Hsu and Steve
 * Overview: This will be the CPU class of the Processor. 
 * It is made up of different functions to handle the different
 * instructions that need to be carried out. (EX: Load/Store...)
 *
*/


import java.util.BitSet;

public class CPU {
    short[] GPR = new short[4];
    short[] IR = new short[4];
    short ISR = 0;
    BitSet PC = new BitSet(12);

	/*public static void main(String [] args)
    {
		// declare the different registers that we need

		// 4 general purpose registers (GPRs)
		short[] GPR = new short[4];

		// 4 index registers
		short[] IR = new short[4];

		// 1 instruction register
		short ISR = 0;

		// PC (12 bits - implemented as a bitset)
		BitSet PC = new BitSet(12);

		System.out.println(PC);
		System.out.println("Length: " + PC.length());

		// test example 
		// suppose: instruction is stored at address 4
		//PC.set(2);

		setPC(PC, 4);
		System.out.println("PC Set" + PC.toString());

		int n = getPC(PC);
		System.out.println("Getting PC: " + n);

		System.out.println("Current value of PC: " + getPC(PC));

		System.out.println("Address of Memory: " + PC.toString());


		// memory - Now implemented as an array of 2048 (can change later)
		short[] memory = new short[2048];

		// storing an instruction into index 4
		memory[4] = 7696;

		// storing the data into index 16
		
		//memory[16] = 2;

		
		GPR[2] = 98;


		// retrieve the value
		int index = bitSetToInt(PC);
		System.out.println(index);
		
		
		//System.out.println(PC.toString());

		process_instruction(index, ISR, memory, IR, GPR);


	}*/


    public void process_instruction(int index) {
        // fetch the value that PC is pointing to (an instruction) and move it into IR
        ISR = Main.memory.memorybank[index];

        //System.out.println("Instruction stored at ISR. ISR = " + memory[index]);

        //find the opcode
        int opcode = ISR >> 10;
        opcode = opcode & 0x3F;
        System.out.println("ISR " + ISR);
        System.out.println("opcode is " + opcode);

        // create an array for the parameters
        int[] parameters;

        // parse the instruction at ISR into Opcode, R, IX, I, Address
        parameters = parseInstruction(ISR, opcode);

        // check the parameters array and see that everything is there

        for (int i = 0; i < parameters.length; i++) {
            System.out.println(parameters[i]);
        }


        // use opcode to figure out what instruction to run

        switch (opcode) {
            case 1:
                // call load
                ldr(parameters[1], parameters[2], parameters[3], parameters[4], Main.memory.memorybank, IR, GPR);
                break;
            case 2:
                str(parameters[1], parameters[2], parameters[3], parameters[4], Main.memory.memorybank, IR, GPR);
                break;
            case 3:
                lda(parameters[1], parameters[2], parameters[3], parameters[4], Main.memory.memorybank, IR, GPR);
                break;
            case 4:
                amr(parameters[1], parameters[2], parameters[3], parameters[4], Main.memory.memorybank, IR, GPR);
                break;
            case 5:
                smr(parameters[1], parameters[2], parameters[3], parameters[4], Main.memory.memorybank, IR, GPR);
                break;
            case 6:
                air(parameters[1], parameters[4], GPR);
                break;
            case 7:
                sir(parameters[1], parameters[4], GPR);
                break;
            case 41:
                ldx(parameters[2], parameters[4], IR, Main.memory.memorybank, parameters[3]);
                break;
            case 42:
                stx(parameters[2], parameters[4], IR, Main.memory.memorybank,parameters[3]);
                break;
            default:
                break;
        }


    }


    // converts the address PC is pointing to into an int
    public int bitSetToInt(BitSet bitSet) {
        int bitInteger = 0;
        for (int i = 0; i < 32; i++) {
            if(bitSet.get(i)) {
                bitInteger |= (1 << i);
            }
        }
        System.out.println("Converting: " + bitInteger);
        return bitInteger;
    }

    // parse the value stored at that index to turn instruction into a sequence of bits
    public int[] parseInstruction(short instruction, int opcode) {
        int GPRValue = 0;
        int IRValue = 0;
        int IAValue = 0;
        int AddressValue = 0;
        int[] parameters = new int[5];
        switch (opcode) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 41:
            case 42:
                GPRValue = (instruction & 0x3FF) >> 8;
                IRValue = (instruction & 0xFF) >> 6;
                IAValue = (instruction & 0x3F) >> 5;
                AddressValue = instruction & 0x1F;
                parameters[0] = opcode;
                parameters[1] = GPRValue;
                parameters[2] = IRValue;
                parameters[3] = IAValue;
                parameters[4] = AddressValue;
                break;
            default:
                break;

        }


        return parameters;
    }

    // load instruction
    public void ldr(int R, int IX, int I, int address, short[] memory, short[] IR, short[] GPR) {
        // calculate the effective address
        int EA = getEA(IX, I, address, memory, IR);


        // load register IX with the contents of the specified address
        GPR[R] = memory[EA];
        System.out.println("Load completed");
        System.out.println(GPR[R]);


    }

    public void str(int R, int IX, int I, int address, short[] memory, short[] IR, short[] GPR) {
        int EA = getEA(IX, I, address, memory, IR);
        System.out.println("EA:" + EA);
        //store
//		memory[EA] = GPR[R];
        Main.memory.set(EA, GPR[R]);
        System.out.println("Store completed");
        System.out.println("memory[EA]" + memory[EA]);
    }

    public void lda(int R, int IX, int I, int address, short[] memory, short[] IR, short[] GPR) {
        int EA = getEA(IX, I, address, memory, IR);

        GPR[R] = (short) EA;
        System.out.println("Store completed");
        System.out.println(GPR[R]);

    }

    public void amr(int R, int IX, int I, int address, short[] memory, short[] IR, short[] GPR) {
        int EA = getEA(IX, I, address, memory, IR);

        GPR[R] = (short) (Main.memory.memorybank[EA] + GPR[R]);
        System.out.println("Load completed");
        System.out.println(GPR[R]);

    }

    public void smr(int R, int IX, int I, int address, short[] memory, short[] IR, short[] GPR) {
        int EA = getEA(IX, I, address, memory, IR);

        GPR[R] = (short) (GPR[R] - Main.memory.memorybank[EA]);
        System.out.println("Load completed");
        System.out.println(GPR[R]);

    }

    public void air(int R, int im, short[] GPR) {
        GPR[R] += (short) im;
        System.out.println("Load completed");
        System.out.println(GPR[R]);
    }

    public void sir(int R, int im, short[] GPR) {
        GPR[R] -= (short) im;
        System.out.println("Load completed");
        System.out.println(GPR[R]);

    }

    public void ldx(int IX, int address, short[] IR, short[] memory, int param) {
        if(param == 0) {
            IR[IX] = (short) address;
        }
        else{
            IR[IX] = Main.memory.memorybank[address];
        }
        System.out.println("Load completed");
        System.out.println("IR[IX]"+IR[IX]);

    }

    public void stx(int IX, int address, short[] IR, short[] memory, int param) {
        if (param == 0) {
            Main.memory.memorybank[address] = IR[IX];
        }else{
            Main.memory.set(Main.memory.memorybank[address],IR[IX]);
        }
        System.out.println("Load completed");
        //System.out.println(memory[address]);

    }


    public int getEA(int IX, int I, int address, short[] memory, short[] IR) {
        System.out.println("IR:" + IR[IX]);
        // handle no indirect addressing
        if(I == 0) {
            if(IX == 0) {
                // load register IX with the contents of the specified address
                return address;
            } else {
                return address + IR[IX];

            }

        } else {
            if(IX == 0) {
                return Main.memory.memorybank[address];

            } else {
                return Main.memory.memorybank[address + IR[IX]];
            }
        }
    }

    // getters and setter for GPR
    public short getGPRValue(int index) {
        return GPR[index];
    }

    public void setGPRValue(int index, short value) {
        GPR[index] = value;
    }

    // getters and setter for IR
    public short getIRValue(int index) {
        return IR[index];
    }

    public void setIRValue(int index, short value) {
        IR[index] = value;
    }

    // getters and setter for ISR
    public short getISRValue() {
        return ISR;
    }

    public void setIRValue(short value) {
        ISR = value;
    }


    public int getPC() {
        return bitSetToInt(PC);
    }

    public void setPC(int value) {
        int index = 0;
        String binaryString = Integer.toBinaryString(value);
        System.out.println(binaryString);
        int j = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if(binaryString.charAt(i) == '1') {
                PC.set(j);
            }
            j++;
        }
        System.out.println("PC final: " + PC.toString());


    }


}